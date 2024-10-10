package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityQuantityFrequency;
import fpml.confirmation.validation.CommodityQuantityFrequencyTypeFormatValidator;
import fpml.confirmation.validation.CommodityQuantityFrequencyValidator;
import fpml.confirmation.validation.exists.CommodityQuantityFrequencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityQuantityFrequency.class)
public class CommodityQuantityFrequencyMeta implements RosettaMetaData<CommodityQuantityFrequency> {

	@Override
	public List<Validator<? super CommodityQuantityFrequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityQuantityFrequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityQuantityFrequency> validator() {
		return new CommodityQuantityFrequencyValidator();
	}

	@Override
	public Validator<? super CommodityQuantityFrequency> typeFormatValidator() {
		return new CommodityQuantityFrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityQuantityFrequency, Set<String>> onlyExistsValidator() {
		return new CommodityQuantityFrequencyOnlyExistsValidator();
	}
}
