package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityInformationSource;
import fpml.confirmation.validation.CommodityInformationSourceTypeFormatValidator;
import fpml.confirmation.validation.CommodityInformationSourceValidator;
import fpml.confirmation.validation.exists.CommodityInformationSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityInformationSource.class)
public class CommodityInformationSourceMeta implements RosettaMetaData<CommodityInformationSource> {

	@Override
	public List<Validator<? super CommodityInformationSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityInformationSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityInformationSource> validator() {
		return new CommodityInformationSourceValidator();
	}

	@Override
	public Validator<? super CommodityInformationSource> typeFormatValidator() {
		return new CommodityInformationSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityInformationSource, Set<String>> onlyExistsValidator() {
		return new CommodityInformationSourceOnlyExistsValidator();
	}
}
