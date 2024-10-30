package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccruingFeeType;
import fpml.confirmation.validation.AccruingFeeTypeTypeFormatValidator;
import fpml.confirmation.validation.AccruingFeeTypeValidator;
import fpml.confirmation.validation.exists.AccruingFeeTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AccruingFeeType.class)
public class AccruingFeeTypeMeta implements RosettaMetaData<AccruingFeeType> {

	@Override
	public List<Validator<? super AccruingFeeType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingFeeType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccruingFeeType> validator() {
		return new AccruingFeeTypeValidator();
	}

	@Override
	public Validator<? super AccruingFeeType> typeFormatValidator() {
		return new AccruingFeeTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingFeeType, Set<String>> onlyExistsValidator() {
		return new AccruingFeeTypeOnlyExistsValidator();
	}
}
