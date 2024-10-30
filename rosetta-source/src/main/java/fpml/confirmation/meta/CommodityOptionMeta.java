package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityOption;
import fpml.confirmation.validation.CommodityOptionTypeFormatValidator;
import fpml.confirmation.validation.CommodityOptionValidator;
import fpml.confirmation.validation.exists.CommodityOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityOption.class)
public class CommodityOptionMeta implements RosettaMetaData<CommodityOption> {

	@Override
	public List<Validator<? super CommodityOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityOption>create(fpml.confirmation.validation.datarule.CommodityOptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityOption> validator() {
		return new CommodityOptionValidator();
	}

	@Override
	public Validator<? super CommodityOption> typeFormatValidator() {
		return new CommodityOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityOption, Set<String>> onlyExistsValidator() {
		return new CommodityOptionOnlyExistsValidator();
	}
}
