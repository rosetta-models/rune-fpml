package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDigitalOption;
import fpml.confirmation.validation.CommodityDigitalOptionTypeFormatValidator;
import fpml.confirmation.validation.CommodityDigitalOptionValidator;
import fpml.confirmation.validation.exists.CommodityDigitalOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityDigitalOption.class)
public class CommodityDigitalOptionMeta implements RosettaMetaData<CommodityDigitalOption> {

	@Override
	public List<Validator<? super CommodityDigitalOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityDigitalOption>create(fpml.confirmation.validation.datarule.CommodityDigitalOptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityDigitalOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityDigitalOption> validator() {
		return new CommodityDigitalOptionValidator();
	}

	@Override
	public Validator<? super CommodityDigitalOption> typeFormatValidator() {
		return new CommodityDigitalOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDigitalOption, Set<String>> onlyExistsValidator() {
		return new CommodityDigitalOptionOnlyExistsValidator();
	}
}
