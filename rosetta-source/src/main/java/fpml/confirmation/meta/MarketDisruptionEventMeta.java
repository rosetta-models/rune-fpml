package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MarketDisruptionEvent;
import fpml.confirmation.validation.MarketDisruptionEventTypeFormatValidator;
import fpml.confirmation.validation.MarketDisruptionEventValidator;
import fpml.confirmation.validation.exists.MarketDisruptionEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MarketDisruptionEvent.class)
public class MarketDisruptionEventMeta implements RosettaMetaData<MarketDisruptionEvent> {

	@Override
	public List<Validator<? super MarketDisruptionEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarketDisruptionEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MarketDisruptionEvent> validator() {
		return new MarketDisruptionEventValidator();
	}

	@Override
	public Validator<? super MarketDisruptionEvent> typeFormatValidator() {
		return new MarketDisruptionEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarketDisruptionEvent, Set<String>> onlyExistsValidator() {
		return new MarketDisruptionEventOnlyExistsValidator();
	}
}
