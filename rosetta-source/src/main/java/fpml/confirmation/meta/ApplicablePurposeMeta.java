package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ApplicablePurpose;
import fpml.confirmation.validation.ApplicablePurposeTypeFormatValidator;
import fpml.confirmation.validation.ApplicablePurposeValidator;
import fpml.confirmation.validation.exists.ApplicablePurposeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ApplicablePurpose.class)
public class ApplicablePurposeMeta implements RosettaMetaData<ApplicablePurpose> {

	@Override
	public List<Validator<? super ApplicablePurpose>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ApplicablePurpose, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ApplicablePurpose> validator() {
		return new ApplicablePurposeValidator();
	}

	@Override
	public Validator<? super ApplicablePurpose> typeFormatValidator() {
		return new ApplicablePurposeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApplicablePurpose, Set<String>> onlyExistsValidator() {
		return new ApplicablePurposeOnlyExistsValidator();
	}
}
