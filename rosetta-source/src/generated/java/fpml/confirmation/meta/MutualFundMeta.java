package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MutualFund;
import fpml.confirmation.validation.MutualFundTypeFormatValidator;
import fpml.confirmation.validation.MutualFundValidator;
import fpml.confirmation.validation.exists.MutualFundOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MutualFund.class)
public class MutualFundMeta implements RosettaMetaData<MutualFund> {

	@Override
	public List<Validator<? super MutualFund>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MutualFund, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MutualFund> validator() {
		return new MutualFundValidator();
	}

	@Override
	public Validator<? super MutualFund> typeFormatValidator() {
		return new MutualFundTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MutualFund, Set<String>> onlyExistsValidator() {
		return new MutualFundOnlyExistsValidator();
	}
}
