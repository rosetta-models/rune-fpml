package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccruingFeeChange;
import fpml.confirmation.validation.AccruingFeeChangeTypeFormatValidator;
import fpml.confirmation.validation.AccruingFeeChangeValidator;
import fpml.confirmation.validation.exists.AccruingFeeChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AccruingFeeChange.class)
public class AccruingFeeChangeMeta implements RosettaMetaData<AccruingFeeChange> {

	@Override
	public List<Validator<? super AccruingFeeChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingFeeChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccruingFeeChange> validator() {
		return new AccruingFeeChangeValidator();
	}

	@Override
	public Validator<? super AccruingFeeChange> typeFormatValidator() {
		return new AccruingFeeChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingFeeChange, Set<String>> onlyExistsValidator() {
		return new AccruingFeeChangeOnlyExistsValidator();
	}
}
