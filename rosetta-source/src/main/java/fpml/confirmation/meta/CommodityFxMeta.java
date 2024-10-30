package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFx;
import fpml.confirmation.validation.CommodityFxTypeFormatValidator;
import fpml.confirmation.validation.CommodityFxValidator;
import fpml.confirmation.validation.exists.CommodityFxOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityFx.class)
public class CommodityFxMeta implements RosettaMetaData<CommodityFx> {

	@Override
	public List<Validator<? super CommodityFx>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityFx>create(fpml.confirmation.validation.datarule.CommodityFxChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityFx, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityFx> validator() {
		return new CommodityFxValidator();
	}

	@Override
	public Validator<? super CommodityFx> typeFormatValidator() {
		return new CommodityFxTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFx, Set<String>> onlyExistsValidator() {
		return new CommodityFxOnlyExistsValidator();
	}
}
