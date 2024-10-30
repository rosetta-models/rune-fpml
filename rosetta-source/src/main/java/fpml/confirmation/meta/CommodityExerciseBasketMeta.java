package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityExerciseBasket;
import fpml.confirmation.validation.CommodityExerciseBasketTypeFormatValidator;
import fpml.confirmation.validation.CommodityExerciseBasketValidator;
import fpml.confirmation.validation.exists.CommodityExerciseBasketOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityExerciseBasket.class)
public class CommodityExerciseBasketMeta implements RosettaMetaData<CommodityExerciseBasket> {

	@Override
	public List<Validator<? super CommodityExerciseBasket>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityExerciseBasket>create(fpml.confirmation.validation.datarule.CommodityExerciseBasketChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityExerciseBasket, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityExerciseBasket> validator() {
		return new CommodityExerciseBasketValidator();
	}

	@Override
	public Validator<? super CommodityExerciseBasket> typeFormatValidator() {
		return new CommodityExerciseBasketTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityExerciseBasket, Set<String>> onlyExistsValidator() {
		return new CommodityExerciseBasketOnlyExistsValidator();
	}
}
