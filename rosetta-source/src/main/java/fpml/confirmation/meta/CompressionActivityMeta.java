package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CompressionActivity;
import fpml.confirmation.validation.CompressionActivityTypeFormatValidator;
import fpml.confirmation.validation.CompressionActivityValidator;
import fpml.confirmation.validation.exists.CompressionActivityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CompressionActivity.class)
public class CompressionActivityMeta implements RosettaMetaData<CompressionActivity> {

	@Override
	public List<Validator<? super CompressionActivity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CompressionActivity>create(fpml.confirmation.validation.datarule.CompressionActivityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CompressionActivity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CompressionActivity> validator() {
		return new CompressionActivityValidator();
	}

	@Override
	public Validator<? super CompressionActivity> typeFormatValidator() {
		return new CompressionActivityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CompressionActivity, Set<String>> onlyExistsValidator() {
		return new CompressionActivityOnlyExistsValidator();
	}
}
