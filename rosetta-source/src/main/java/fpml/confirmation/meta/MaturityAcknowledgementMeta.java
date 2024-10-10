package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MaturityAcknowledgement;
import fpml.confirmation.validation.MaturityAcknowledgementTypeFormatValidator;
import fpml.confirmation.validation.MaturityAcknowledgementValidator;
import fpml.confirmation.validation.exists.MaturityAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MaturityAcknowledgement.class)
public class MaturityAcknowledgementMeta implements RosettaMetaData<MaturityAcknowledgement> {

	@Override
	public List<Validator<? super MaturityAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MaturityAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MaturityAcknowledgement> validator() {
		return new MaturityAcknowledgementValidator();
	}

	@Override
	public Validator<? super MaturityAcknowledgement> typeFormatValidator() {
		return new MaturityAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MaturityAcknowledgement, Set<String>> onlyExistsValidator() {
		return new MaturityAcknowledgementOnlyExistsValidator();
	}
}
