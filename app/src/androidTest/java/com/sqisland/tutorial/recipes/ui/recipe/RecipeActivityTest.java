package com.sqisland.tutorial.recipes.ui.recipe;

import androidx.test.espresso.ViewInteraction;
import androidx.test.rule.ActivityTestRule;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.test.RecipeRobot;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class RecipeActivityTest {
    private static final String CARROT_ID = "creamed_carrots";
    @Rule
    public ActivityTestRule<RecipeActivity> activityTestRule = new ActivityTestRule<>(
            RecipeActivity.class, true, false
    );
    
    @Test
    public void recipeNotFound() {
        new RecipeRobot()
                .launch(activityTestRule)
                .noTitle()
                .description(R.string.recipe_not_found);
    }
    
    @Test
    public void clickToFavorite() {
        RecipeRobot robot = new RecipeRobot()
                .launch(activityTestRule, CARROT_ID);
        
        ViewInteraction title =
                onView(withId(R.id.title))
                        .check(matches(withText("Creamed Carrots")));
        
        robot.isNotFavorite();
        
        title.perform(click());
        
        robot.isFavorite();
    }
    
    @Test
    public void alreadyFavorite() {
        new RecipeRobot()
                .setFavorite(CARROT_ID)
                .launch(activityTestRule, CARROT_ID)
                .isFavorite();
    }
}