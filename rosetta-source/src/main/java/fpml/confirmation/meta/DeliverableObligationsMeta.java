package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DeliverableObligations;
import fpml.confirmation.validation.DeliverableObligationsTypeFormatValidator;
import fpml.confirmation.validation.DeliverableObligationsValidator;
import fpml.confirmation.validation.exists.DeliverableObligationsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DeliverableObligations.class)
public class DeliverableObligationsMeta implements RosettaMetaData<DeliverableObligations> {

	@Override
	public List<Validator<? super DeliverableObligations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.DeliverableObligations>create(fpml.confirmation.validation.datarule.DeliverableObligationsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DeliverableObligations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DeliverableObligations> validator() {
		return new DeliverableObligationsValidator();
	}

	@Override
	public Validator<? super DeliverableObligations> typeFormatValidator() {
		return new DeliverableObligationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeliverableObligations, Set<String>> onlyExistsValidator() {
		return new DeliverableObligationsOnlyExistsValidator();
	}
}
