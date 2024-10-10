package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDetails;
import fpml.confirmation.validation.CommodityDetailsTypeFormatValidator;
import fpml.confirmation.validation.CommodityDetailsValidator;
import fpml.confirmation.validation.exists.CommodityDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityDetails.class)
public class CommodityDetailsMeta implements RosettaMetaData<CommodityDetails> {

	@Override
	public List<Validator<? super CommodityDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityDetails> validator() {
		return new CommodityDetailsValidator();
	}

	@Override
	public Validator<? super CommodityDetails> typeFormatValidator() {
		return new CommodityDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDetails, Set<String>> onlyExistsValidator() {
		return new CommodityDetailsOnlyExistsValidator();
	}
}
