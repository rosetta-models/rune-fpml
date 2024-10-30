package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionEvent;
import fpml.confirmation.validation.OptionEventTypeFormatValidator;
import fpml.confirmation.validation.OptionEventValidator;
import fpml.confirmation.validation.exists.OptionEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OptionEvent.class)
public class OptionEventMeta implements RosettaMetaData<OptionEvent> {

	@Override
	public List<Validator<? super OptionEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OptionEvent>create(fpml.confirmation.validation.datarule.OptionEventChoice0.class),
			factory.<fpml.confirmation.OptionEvent>create(fpml.confirmation.validation.datarule.OptionEventChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super OptionEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionEvent> validator() {
		return new OptionEventValidator();
	}

	@Override
	public Validator<? super OptionEvent> typeFormatValidator() {
		return new OptionEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionEvent, Set<String>> onlyExistsValidator() {
		return new OptionEventOnlyExistsValidator();
	}
}
