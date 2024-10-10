package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Compounding;
import fpml.confirmation.validation.CompoundingTypeFormatValidator;
import fpml.confirmation.validation.CompoundingValidator;
import fpml.confirmation.validation.exists.CompoundingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Compounding.class)
public class CompoundingMeta implements RosettaMetaData<Compounding> {

	@Override
	public List<Validator<? super Compounding>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Compounding, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Compounding> validator() {
		return new CompoundingValidator();
	}

	@Override
	public Validator<? super Compounding> typeFormatValidator() {
		return new CompoundingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Compounding, Set<String>> onlyExistsValidator() {
		return new CompoundingOnlyExistsValidator();
	}
}
