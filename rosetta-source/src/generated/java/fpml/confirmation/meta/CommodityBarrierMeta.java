package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBarrier;
import fpml.confirmation.validation.CommodityBarrierTypeFormatValidator;
import fpml.confirmation.validation.CommodityBarrierValidator;
import fpml.confirmation.validation.exists.CommodityBarrierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityBarrier.class)
public class CommodityBarrierMeta implements RosettaMetaData<CommodityBarrier> {

	@Override
	public List<Validator<? super CommodityBarrier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBarrier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityBarrier> validator() {
		return new CommodityBarrierValidator();
	}

	@Override
	public Validator<? super CommodityBarrier> typeFormatValidator() {
		return new CommodityBarrierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBarrier, Set<String>> onlyExistsValidator() {
		return new CommodityBarrierOnlyExistsValidator();
	}
}
