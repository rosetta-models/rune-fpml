package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationIdModel;
import fpml.confirmation.validation.CorrelationIdModelTypeFormatValidator;
import fpml.confirmation.validation.CorrelationIdModelValidator;
import fpml.confirmation.validation.exists.CorrelationIdModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CorrelationIdModel.class)
public class CorrelationIdModelMeta implements RosettaMetaData<CorrelationIdModel> {

	@Override
	public List<Validator<? super CorrelationIdModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorrelationIdModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CorrelationIdModel> validator() {
		return new CorrelationIdModelValidator();
	}

	@Override
	public Validator<? super CorrelationIdModel> typeFormatValidator() {
		return new CorrelationIdModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorrelationIdModel, Set<String>> onlyExistsValidator() {
		return new CorrelationIdModelOnlyExistsValidator();
	}
}
