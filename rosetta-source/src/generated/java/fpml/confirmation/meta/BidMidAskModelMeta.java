package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BidMidAskModel;
import fpml.confirmation.validation.BidMidAskModelTypeFormatValidator;
import fpml.confirmation.validation.BidMidAskModelValidator;
import fpml.confirmation.validation.exists.BidMidAskModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BidMidAskModel.class)
public class BidMidAskModelMeta implements RosettaMetaData<BidMidAskModel> {

	@Override
	public List<Validator<? super BidMidAskModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BidMidAskModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BidMidAskModel> validator() {
		return new BidMidAskModelValidator();
	}

	@Override
	public Validator<? super BidMidAskModel> typeFormatValidator() {
		return new BidMidAskModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BidMidAskModel, Set<String>> onlyExistsValidator() {
		return new BidMidAskModelOnlyExistsValidator();
	}
}
