package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityReturnLeg;
import fpml.confirmation.validation.CommodityReturnLegTypeFormatValidator;
import fpml.confirmation.validation.CommodityReturnLegValidator;
import fpml.confirmation.validation.exists.CommodityReturnLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityReturnLeg.class)
public class CommodityReturnLegMeta implements RosettaMetaData<CommodityReturnLeg> {

	@Override
	public List<Validator<? super CommodityReturnLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityReturnLeg>create(fpml.confirmation.validation.datarule.CommodityReturnLegChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityReturnLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityReturnLeg> validator() {
		return new CommodityReturnLegValidator();
	}

	@Override
	public Validator<? super CommodityReturnLeg> typeFormatValidator() {
		return new CommodityReturnLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityReturnLeg, Set<String>> onlyExistsValidator() {
		return new CommodityReturnLegOnlyExistsValidator();
	}
}
