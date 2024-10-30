package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractFacilityContractEvent;
import fpml.confirmation.validation.AbstractFacilityContractEventTypeFormatValidator;
import fpml.confirmation.validation.AbstractFacilityContractEventValidator;
import fpml.confirmation.validation.exists.AbstractFacilityContractEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AbstractFacilityContractEvent.class)
public class AbstractFacilityContractEventMeta implements RosettaMetaData<AbstractFacilityContractEvent> {

	@Override
	public List<Validator<? super AbstractFacilityContractEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractFacilityContractEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractFacilityContractEvent> validator() {
		return new AbstractFacilityContractEventValidator();
	}

	@Override
	public Validator<? super AbstractFacilityContractEvent> typeFormatValidator() {
		return new AbstractFacilityContractEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractFacilityContractEvent, Set<String>> onlyExistsValidator() {
		return new AbstractFacilityContractEventOnlyExistsValidator();
	}
}
