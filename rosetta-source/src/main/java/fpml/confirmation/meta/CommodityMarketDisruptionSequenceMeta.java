package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityMarketDisruptionSequence;
import fpml.confirmation.validation.CommodityMarketDisruptionSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityMarketDisruptionSequenceValidator;
import fpml.confirmation.validation.exists.CommodityMarketDisruptionSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityMarketDisruptionSequence.class)
public class CommodityMarketDisruptionSequenceMeta implements RosettaMetaData<CommodityMarketDisruptionSequence> {

	@Override
	public List<Validator<? super CommodityMarketDisruptionSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityMarketDisruptionSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityMarketDisruptionSequence> validator() {
		return new CommodityMarketDisruptionSequenceValidator();
	}

	@Override
	public Validator<? super CommodityMarketDisruptionSequence> typeFormatValidator() {
		return new CommodityMarketDisruptionSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMarketDisruptionSequence, Set<String>> onlyExistsValidator() {
		return new CommodityMarketDisruptionSequenceOnlyExistsValidator();
	}
}
