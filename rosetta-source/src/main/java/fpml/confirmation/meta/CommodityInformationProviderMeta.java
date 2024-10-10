package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityInformationProvider;
import fpml.confirmation.validation.CommodityInformationProviderTypeFormatValidator;
import fpml.confirmation.validation.CommodityInformationProviderValidator;
import fpml.confirmation.validation.exists.CommodityInformationProviderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityInformationProvider.class)
public class CommodityInformationProviderMeta implements RosettaMetaData<CommodityInformationProvider> {

	@Override
	public List<Validator<? super CommodityInformationProvider>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityInformationProvider, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityInformationProvider> validator() {
		return new CommodityInformationProviderValidator();
	}

	@Override
	public Validator<? super CommodityInformationProvider> typeFormatValidator() {
		return new CommodityInformationProviderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityInformationProvider, Set<String>> onlyExistsValidator() {
		return new CommodityInformationProviderOnlyExistsValidator();
	}
}
