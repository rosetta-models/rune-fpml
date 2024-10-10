package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OldTradeModel;
import fpml.confirmation.validation.OldTradeModelTypeFormatValidator;
import fpml.confirmation.validation.OldTradeModelValidator;
import fpml.confirmation.validation.exists.OldTradeModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OldTradeModel.class)
public class OldTradeModelMeta implements RosettaMetaData<OldTradeModel> {

	@Override
	public List<Validator<? super OldTradeModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OldTradeModel>create(fpml.confirmation.validation.datarule.OldTradeModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OldTradeModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OldTradeModel> validator() {
		return new OldTradeModelValidator();
	}

	@Override
	public Validator<? super OldTradeModel> typeFormatValidator() {
		return new OldTradeModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OldTradeModel, Set<String>> onlyExistsValidator() {
		return new OldTradeModelOnlyExistsValidator();
	}
}
