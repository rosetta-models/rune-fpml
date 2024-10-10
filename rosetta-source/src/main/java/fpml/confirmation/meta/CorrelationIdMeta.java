package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationId;
import fpml.confirmation.validation.CorrelationIdTypeFormatValidator;
import fpml.confirmation.validation.CorrelationIdValidator;
import fpml.confirmation.validation.exists.CorrelationIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CorrelationId.class)
public class CorrelationIdMeta implements RosettaMetaData<CorrelationId> {

	@Override
	public List<Validator<? super CorrelationId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorrelationId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CorrelationId> validator() {
		return new CorrelationIdValidator();
	}

	@Override
	public Validator<? super CorrelationId> typeFormatValidator() {
		return new CorrelationIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorrelationId, Set<String>> onlyExistsValidator() {
		return new CorrelationIdOnlyExistsValidator();
	}
}
