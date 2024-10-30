package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityProductModelSequenceChoice;
import fpml.confirmation.validation.CommodityProductModelSequenceChoiceTypeFormatValidator;
import fpml.confirmation.validation.CommodityProductModelSequenceChoiceValidator;
import fpml.confirmation.validation.exists.CommodityProductModelSequenceChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityProductModelSequenceChoice.class)
public class CommodityProductModelSequenceChoiceMeta implements RosettaMetaData<CommodityProductModelSequenceChoice> {

	@Override
	public List<Validator<? super CommodityProductModelSequenceChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityProductModelSequenceChoice>create(fpml.confirmation.validation.datarule.CommodityProductModelSequenceChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityProductModelSequenceChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityProductModelSequenceChoice> validator() {
		return new CommodityProductModelSequenceChoiceValidator();
	}

	@Override
	public Validator<? super CommodityProductModelSequenceChoice> typeFormatValidator() {
		return new CommodityProductModelSequenceChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityProductModelSequenceChoice, Set<String>> onlyExistsValidator() {
		return new CommodityProductModelSequenceChoiceOnlyExistsValidator();
	}
}
