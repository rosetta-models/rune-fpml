package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommoditySwaptionUnderlying;
import fpml.confirmation.validation.CommoditySwaptionUnderlyingTypeFormatValidator;
import fpml.confirmation.validation.CommoditySwaptionUnderlyingValidator;
import fpml.confirmation.validation.exists.CommoditySwaptionUnderlyingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommoditySwaptionUnderlying.class)
public class CommoditySwaptionUnderlyingMeta implements RosettaMetaData<CommoditySwaptionUnderlying> {

	@Override
	public List<Validator<? super CommoditySwaptionUnderlying>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommoditySwaptionUnderlying, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommoditySwaptionUnderlying> validator() {
		return new CommoditySwaptionUnderlyingValidator();
	}

	@Override
	public Validator<? super CommoditySwaptionUnderlying> typeFormatValidator() {
		return new CommoditySwaptionUnderlyingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySwaptionUnderlying, Set<String>> onlyExistsValidator() {
		return new CommoditySwaptionUnderlyingOnlyExistsValidator();
	}
}
