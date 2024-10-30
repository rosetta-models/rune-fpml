package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityProductModelSequence;
import fpml.confirmation.validation.CommodityProductModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityProductModelSequenceValidator;
import fpml.confirmation.validation.exists.CommodityProductModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityProductModelSequence.class)
public class CommodityProductModelSequenceMeta implements RosettaMetaData<CommodityProductModelSequence> {

	@Override
	public List<Validator<? super CommodityProductModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityProductModelSequence>create(fpml.confirmation.validation.datarule.CommodityProductModelSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityProductModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityProductModelSequence> validator() {
		return new CommodityProductModelSequenceValidator();
	}

	@Override
	public Validator<? super CommodityProductModelSequence> typeFormatValidator() {
		return new CommodityProductModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityProductModelSequence, Set<String>> onlyExistsValidator() {
		return new CommodityProductModelSequenceOnlyExistsValidator();
	}
}
