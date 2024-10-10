package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityTrigger;
import fpml.confirmation.validation.CommodityTriggerTypeFormatValidator;
import fpml.confirmation.validation.CommodityTriggerValidator;
import fpml.confirmation.validation.exists.CommodityTriggerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityTrigger.class)
public class CommodityTriggerMeta implements RosettaMetaData<CommodityTrigger> {

	@Override
	public List<Validator<? super CommodityTrigger>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityTrigger>create(fpml.confirmation.validation.datarule.CommodityTriggerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityTrigger, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityTrigger> validator() {
		return new CommodityTriggerValidator();
	}

	@Override
	public Validator<? super CommodityTrigger> typeFormatValidator() {
		return new CommodityTriggerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityTrigger, Set<String>> onlyExistsValidator() {
		return new CommodityTriggerOnlyExistsValidator();
	}
}
