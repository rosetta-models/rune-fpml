package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OtcClassification;
import fpml.confirmation.validation.OtcClassificationTypeFormatValidator;
import fpml.confirmation.validation.OtcClassificationValidator;
import fpml.confirmation.validation.exists.OtcClassificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OtcClassification.class)
public class OtcClassificationMeta implements RosettaMetaData<OtcClassification> {

	@Override
	public List<Validator<? super OtcClassification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtcClassification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OtcClassification> validator() {
		return new OtcClassificationValidator();
	}

	@Override
	public Validator<? super OtcClassification> typeFormatValidator() {
		return new OtcClassificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtcClassification, Set<String>> onlyExistsValidator() {
		return new OtcClassificationOnlyExistsValidator();
	}
}
