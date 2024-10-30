package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.validation.CorrelationAndOptionalSequenceModelTypeFormatValidator;
import fpml.confirmation.validation.CorrelationAndOptionalSequenceModelValidator;
import fpml.confirmation.validation.exists.CorrelationAndOptionalSequenceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CorrelationAndOptionalSequenceModel.class)
public class CorrelationAndOptionalSequenceModelMeta implements RosettaMetaData<CorrelationAndOptionalSequenceModel> {

	@Override
	public List<Validator<? super CorrelationAndOptionalSequenceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorrelationAndOptionalSequenceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CorrelationAndOptionalSequenceModel> validator() {
		return new CorrelationAndOptionalSequenceModelValidator();
	}

	@Override
	public Validator<? super CorrelationAndOptionalSequenceModel> typeFormatValidator() {
		return new CorrelationAndOptionalSequenceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorrelationAndOptionalSequenceModel, Set<String>> onlyExistsValidator() {
		return new CorrelationAndOptionalSequenceModelOnlyExistsValidator();
	}
}
