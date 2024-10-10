package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFrequencyType;
import fpml.confirmation.validation.CommodityFrequencyTypeTypeFormatValidator;
import fpml.confirmation.validation.CommodityFrequencyTypeValidator;
import fpml.confirmation.validation.exists.CommodityFrequencyTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityFrequencyType.class)
public class CommodityFrequencyTypeMeta implements RosettaMetaData<CommodityFrequencyType> {

	@Override
	public List<Validator<? super CommodityFrequencyType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityFrequencyType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityFrequencyType> validator() {
		return new CommodityFrequencyTypeValidator();
	}

	@Override
	public Validator<? super CommodityFrequencyType> typeFormatValidator() {
		return new CommodityFrequencyTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFrequencyType, Set<String>> onlyExistsValidator() {
		return new CommodityFrequencyTypeOnlyExistsValidator();
	}
}
