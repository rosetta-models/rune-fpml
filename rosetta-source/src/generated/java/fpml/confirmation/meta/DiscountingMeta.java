package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Discounting;
import fpml.confirmation.validation.DiscountingTypeFormatValidator;
import fpml.confirmation.validation.DiscountingValidator;
import fpml.confirmation.validation.exists.DiscountingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Discounting.class)
public class DiscountingMeta implements RosettaMetaData<Discounting> {

	@Override
	public List<Validator<? super Discounting>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Discounting, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Discounting> validator() {
		return new DiscountingValidator();
	}

	@Override
	public Validator<? super Discounting> typeFormatValidator() {
		return new DiscountingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Discounting, Set<String>> onlyExistsValidator() {
		return new DiscountingOnlyExistsValidator();
	}
}
