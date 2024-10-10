package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeChangeBase;
import fpml.confirmation.validation.TradeChangeBaseTypeFormatValidator;
import fpml.confirmation.validation.TradeChangeBaseValidator;
import fpml.confirmation.validation.exists.TradeChangeBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeChangeBase.class)
public class TradeChangeBaseMeta implements RosettaMetaData<TradeChangeBase> {

	@Override
	public List<Validator<? super TradeChangeBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeChangeBase>create(fpml.confirmation.validation.datarule.TradeChangeBaseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeChangeBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeChangeBase> validator() {
		return new TradeChangeBaseValidator();
	}

	@Override
	public Validator<? super TradeChangeBase> typeFormatValidator() {
		return new TradeChangeBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeChangeBase, Set<String>> onlyExistsValidator() {
		return new TradeChangeBaseOnlyExistsValidator();
	}
}
