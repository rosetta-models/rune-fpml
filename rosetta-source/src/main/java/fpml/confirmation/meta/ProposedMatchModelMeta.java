package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ProposedMatchModel;
import fpml.confirmation.validation.ProposedMatchModelTypeFormatValidator;
import fpml.confirmation.validation.ProposedMatchModelValidator;
import fpml.confirmation.validation.exists.ProposedMatchModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ProposedMatchModel.class)
public class ProposedMatchModelMeta implements RosettaMetaData<ProposedMatchModel> {

	@Override
	public List<Validator<? super ProposedMatchModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProposedMatchModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ProposedMatchModel> validator() {
		return new ProposedMatchModelValidator();
	}

	@Override
	public Validator<? super ProposedMatchModel> typeFormatValidator() {
		return new ProposedMatchModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProposedMatchModel, Set<String>> onlyExistsValidator() {
		return new ProposedMatchModelOnlyExistsValidator();
	}
}
