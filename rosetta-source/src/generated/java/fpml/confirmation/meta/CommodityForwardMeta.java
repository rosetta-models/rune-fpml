package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityForward;
import fpml.confirmation.validation.CommodityForwardTypeFormatValidator;
import fpml.confirmation.validation.CommodityForwardValidator;
import fpml.confirmation.validation.exists.CommodityForwardOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityForward.class)
public class CommodityForwardMeta implements RosettaMetaData<CommodityForward> {

	@Override
	public List<Validator<? super CommodityForward>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityForward>create(fpml.confirmation.validation.datarule.CommodityForwardChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityForward, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityForward> validator() {
		return new CommodityForwardValidator();
	}

	@Override
	public Validator<? super CommodityForward> typeFormatValidator() {
		return new CommodityForwardTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityForward, Set<String>> onlyExistsValidator() {
		return new CommodityForwardOnlyExistsValidator();
	}
}
