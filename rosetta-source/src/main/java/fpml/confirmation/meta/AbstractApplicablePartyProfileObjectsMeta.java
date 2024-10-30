package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractApplicablePartyProfileObjects;
import fpml.confirmation.validation.AbstractApplicablePartyProfileObjectsTypeFormatValidator;
import fpml.confirmation.validation.AbstractApplicablePartyProfileObjectsValidator;
import fpml.confirmation.validation.exists.AbstractApplicablePartyProfileObjectsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AbstractApplicablePartyProfileObjects.class)
public class AbstractApplicablePartyProfileObjectsMeta implements RosettaMetaData<AbstractApplicablePartyProfileObjects> {

	@Override
	public List<Validator<? super AbstractApplicablePartyProfileObjects>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractApplicablePartyProfileObjects, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractApplicablePartyProfileObjects> validator() {
		return new AbstractApplicablePartyProfileObjectsValidator();
	}

	@Override
	public Validator<? super AbstractApplicablePartyProfileObjects> typeFormatValidator() {
		return new AbstractApplicablePartyProfileObjectsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractApplicablePartyProfileObjects, Set<String>> onlyExistsValidator() {
		return new AbstractApplicablePartyProfileObjectsOnlyExistsValidator();
	}
}
