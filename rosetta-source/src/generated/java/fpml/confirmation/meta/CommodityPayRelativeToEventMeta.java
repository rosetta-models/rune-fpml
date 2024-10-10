package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPayRelativeToEvent;
import fpml.confirmation.validation.CommodityPayRelativeToEventTypeFormatValidator;
import fpml.confirmation.validation.CommodityPayRelativeToEventValidator;
import fpml.confirmation.validation.exists.CommodityPayRelativeToEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityPayRelativeToEvent.class)
public class CommodityPayRelativeToEventMeta implements RosettaMetaData<CommodityPayRelativeToEvent> {

	@Override
	public List<Validator<? super CommodityPayRelativeToEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPayRelativeToEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPayRelativeToEvent> validator() {
		return new CommodityPayRelativeToEventValidator();
	}

	@Override
	public Validator<? super CommodityPayRelativeToEvent> typeFormatValidator() {
		return new CommodityPayRelativeToEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPayRelativeToEvent, Set<String>> onlyExistsValidator() {
		return new CommodityPayRelativeToEventOnlyExistsValidator();
	}
}
