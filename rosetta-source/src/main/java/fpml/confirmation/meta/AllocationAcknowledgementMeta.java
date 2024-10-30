package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AllocationAcknowledgement;
import fpml.confirmation.validation.AllocationAcknowledgementTypeFormatValidator;
import fpml.confirmation.validation.AllocationAcknowledgementValidator;
import fpml.confirmation.validation.exists.AllocationAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AllocationAcknowledgement.class)
public class AllocationAcknowledgementMeta implements RosettaMetaData<AllocationAcknowledgement> {

	@Override
	public List<Validator<? super AllocationAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AllocationAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AllocationAcknowledgement> validator() {
		return new AllocationAcknowledgementValidator();
	}

	@Override
	public Validator<? super AllocationAcknowledgement> typeFormatValidator() {
		return new AllocationAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AllocationAcknowledgement, Set<String>> onlyExistsValidator() {
		return new AllocationAcknowledgementOnlyExistsValidator();
	}
}
