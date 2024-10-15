package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityMetalProducer;
import fpml.confirmation.validation.CommodityMetalProducerTypeFormatValidator;
import fpml.confirmation.validation.CommodityMetalProducerValidator;
import fpml.confirmation.validation.exists.CommodityMetalProducerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityMetalProducer.class)
public class CommodityMetalProducerMeta implements RosettaMetaData<CommodityMetalProducer> {

	@Override
	public List<Validator<? super CommodityMetalProducer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityMetalProducer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityMetalProducer> validator() {
		return new CommodityMetalProducerValidator();
	}

	@Override
	public Validator<? super CommodityMetalProducer> typeFormatValidator() {
		return new CommodityMetalProducerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMetalProducer, Set<String>> onlyExistsValidator() {
		return new CommodityMetalProducerOnlyExistsValidator();
	}
}
