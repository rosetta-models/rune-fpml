package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LcPurpose;
import fpml.confirmation.validation.LcPurposeTypeFormatValidator;
import fpml.confirmation.validation.LcPurposeValidator;
import fpml.confirmation.validation.exists.LcPurposeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LcPurpose.class)
public class LcPurposeMeta implements RosettaMetaData<LcPurpose> {

	@Override
	public List<Validator<? super LcPurpose>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcPurpose, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LcPurpose> validator() {
		return new LcPurposeValidator();
	}

	@Override
	public Validator<? super LcPurpose> typeFormatValidator() {
		return new LcPurposeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcPurpose, Set<String>> onlyExistsValidator() {
		return new LcPurposeOnlyExistsValidator();
	}
}
