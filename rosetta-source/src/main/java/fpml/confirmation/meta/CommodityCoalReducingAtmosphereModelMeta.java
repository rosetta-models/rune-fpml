package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCoalReducingAtmosphereModel;
import fpml.confirmation.validation.CommodityCoalReducingAtmosphereModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityCoalReducingAtmosphereModelValidator;
import fpml.confirmation.validation.exists.CommodityCoalReducingAtmosphereModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityCoalReducingAtmosphereModel.class)
public class CommodityCoalReducingAtmosphereModelMeta implements RosettaMetaData<CommodityCoalReducingAtmosphereModel> {

	@Override
	public List<Validator<? super CommodityCoalReducingAtmosphereModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityCoalReducingAtmosphereModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityCoalReducingAtmosphereModel> validator() {
		return new CommodityCoalReducingAtmosphereModelValidator();
	}

	@Override
	public Validator<? super CommodityCoalReducingAtmosphereModel> typeFormatValidator() {
		return new CommodityCoalReducingAtmosphereModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityCoalReducingAtmosphereModel, Set<String>> onlyExistsValidator() {
		return new CommodityCoalReducingAtmosphereModelOnlyExistsValidator();
	}
}
