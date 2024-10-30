package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.validation.CorrelationAndSequenceModelTypeFormatValidator;
import fpml.confirmation.validation.CorrelationAndSequenceModelValidator;
import fpml.confirmation.validation.exists.CorrelationAndSequenceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CorrelationAndSequenceModel.class)
public class CorrelationAndSequenceModelMeta implements RosettaMetaData<CorrelationAndSequenceModel> {

	@Override
	public List<Validator<? super CorrelationAndSequenceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorrelationAndSequenceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CorrelationAndSequenceModel> validator() {
		return new CorrelationAndSequenceModelValidator();
	}

	@Override
	public Validator<? super CorrelationAndSequenceModel> typeFormatValidator() {
		return new CorrelationAndSequenceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorrelationAndSequenceModel, Set<String>> onlyExistsValidator() {
		return new CorrelationAndSequenceModelOnlyExistsValidator();
	}
}
