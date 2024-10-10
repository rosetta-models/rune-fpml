package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBase;
import fpml.confirmation.validation.CommodityBaseTypeFormatValidator;
import fpml.confirmation.validation.CommodityBaseValidator;
import fpml.confirmation.validation.exists.CommodityBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityBase.class)
public class CommodityBaseMeta implements RosettaMetaData<CommodityBase> {

	@Override
	public List<Validator<? super CommodityBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityBase> validator() {
		return new CommodityBaseValidator();
	}

	@Override
	public Validator<? super CommodityBase> typeFormatValidator() {
		return new CommodityBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBase, Set<String>> onlyExistsValidator() {
		return new CommodityBaseOnlyExistsValidator();
	}
}
