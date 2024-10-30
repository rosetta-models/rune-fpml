package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BankruptcyEvent;
import fpml.confirmation.validation.BankruptcyEventTypeFormatValidator;
import fpml.confirmation.validation.BankruptcyEventValidator;
import fpml.confirmation.validation.exists.BankruptcyEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BankruptcyEvent.class)
public class BankruptcyEventMeta implements RosettaMetaData<BankruptcyEvent> {

	@Override
	public List<Validator<? super BankruptcyEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BankruptcyEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BankruptcyEvent> validator() {
		return new BankruptcyEventValidator();
	}

	@Override
	public Validator<? super BankruptcyEvent> typeFormatValidator() {
		return new BankruptcyEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BankruptcyEvent, Set<String>> onlyExistsValidator() {
		return new BankruptcyEventOnlyExistsValidator();
	}
}
