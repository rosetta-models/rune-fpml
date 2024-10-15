package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityNotionalQuantityModelSequence;
import fpml.confirmation.validation.CommodityNotionalQuantityModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityNotionalQuantityModelSequenceValidator;
import fpml.confirmation.validation.exists.CommodityNotionalQuantityModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityNotionalQuantityModelSequence.class)
public class CommodityNotionalQuantityModelSequenceMeta implements RosettaMetaData<CommodityNotionalQuantityModelSequence> {

	@Override
	public List<Validator<? super CommodityNotionalQuantityModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityNotionalQuantityModelSequence>create(fpml.confirmation.validation.datarule.CommodityNotionalQuantityModelSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityNotionalQuantityModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityNotionalQuantityModelSequence> validator() {
		return new CommodityNotionalQuantityModelSequenceValidator();
	}

	@Override
	public Validator<? super CommodityNotionalQuantityModelSequence> typeFormatValidator() {
		return new CommodityNotionalQuantityModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityNotionalQuantityModelSequence, Set<String>> onlyExistsValidator() {
		return new CommodityNotionalQuantityModelSequenceOnlyExistsValidator();
	}
}
