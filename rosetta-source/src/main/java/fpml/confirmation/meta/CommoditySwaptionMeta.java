package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommoditySwaption;
import fpml.confirmation.validation.CommoditySwaptionTypeFormatValidator;
import fpml.confirmation.validation.CommoditySwaptionValidator;
import fpml.confirmation.validation.exists.CommoditySwaptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommoditySwaption.class)
public class CommoditySwaptionMeta implements RosettaMetaData<CommoditySwaption> {

	@Override
	public List<Validator<? super CommoditySwaption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommoditySwaption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommoditySwaption> validator() {
		return new CommoditySwaptionValidator();
	}

	@Override
	public Validator<? super CommoditySwaption> typeFormatValidator() {
		return new CommoditySwaptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySwaption, Set<String>> onlyExistsValidator() {
		return new CommoditySwaptionOnlyExistsValidator();
	}
}
