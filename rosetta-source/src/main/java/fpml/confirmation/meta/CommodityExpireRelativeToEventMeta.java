package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityExpireRelativeToEvent;
import fpml.confirmation.validation.CommodityExpireRelativeToEventTypeFormatValidator;
import fpml.confirmation.validation.CommodityExpireRelativeToEventValidator;
import fpml.confirmation.validation.exists.CommodityExpireRelativeToEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityExpireRelativeToEvent.class)
public class CommodityExpireRelativeToEventMeta implements RosettaMetaData<CommodityExpireRelativeToEvent> {

	@Override
	public List<Validator<? super CommodityExpireRelativeToEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityExpireRelativeToEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityExpireRelativeToEvent> validator() {
		return new CommodityExpireRelativeToEventValidator();
	}

	@Override
	public Validator<? super CommodityExpireRelativeToEvent> typeFormatValidator() {
		return new CommodityExpireRelativeToEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityExpireRelativeToEvent, Set<String>> onlyExistsValidator() {
		return new CommodityExpireRelativeToEventOnlyExistsValidator();
	}
}
