package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RepudiationMoratoriumEvent;
import fpml.confirmation.validation.RepudiationMoratoriumEventTypeFormatValidator;
import fpml.confirmation.validation.RepudiationMoratoriumEventValidator;
import fpml.confirmation.validation.exists.RepudiationMoratoriumEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RepudiationMoratoriumEvent.class)
public class RepudiationMoratoriumEventMeta implements RosettaMetaData<RepudiationMoratoriumEvent> {

	@Override
	public List<Validator<? super RepudiationMoratoriumEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RepudiationMoratoriumEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RepudiationMoratoriumEvent> validator() {
		return new RepudiationMoratoriumEventValidator();
	}

	@Override
	public Validator<? super RepudiationMoratoriumEvent> typeFormatValidator() {
		return new RepudiationMoratoriumEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RepudiationMoratoriumEvent, Set<String>> onlyExistsValidator() {
		return new RepudiationMoratoriumEventOnlyExistsValidator();
	}
}
