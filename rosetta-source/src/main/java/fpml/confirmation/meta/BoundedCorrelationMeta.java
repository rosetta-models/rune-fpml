package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BoundedCorrelation;
import fpml.confirmation.validation.BoundedCorrelationTypeFormatValidator;
import fpml.confirmation.validation.BoundedCorrelationValidator;
import fpml.confirmation.validation.exists.BoundedCorrelationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BoundedCorrelation.class)
public class BoundedCorrelationMeta implements RosettaMetaData<BoundedCorrelation> {

	@Override
	public List<Validator<? super BoundedCorrelation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BoundedCorrelation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BoundedCorrelation> validator() {
		return new BoundedCorrelationValidator();
	}

	@Override
	public Validator<? super BoundedCorrelation> typeFormatValidator() {
		return new BoundedCorrelationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BoundedCorrelation, Set<String>> onlyExistsValidator() {
		return new BoundedCorrelationOnlyExistsValidator();
	}
}
