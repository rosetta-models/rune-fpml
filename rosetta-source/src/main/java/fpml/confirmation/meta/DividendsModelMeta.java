package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendsModel;
import fpml.confirmation.validation.DividendsModelTypeFormatValidator;
import fpml.confirmation.validation.DividendsModelValidator;
import fpml.confirmation.validation.exists.DividendsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DividendsModel.class)
public class DividendsModelMeta implements RosettaMetaData<DividendsModel> {

	@Override
	public List<Validator<? super DividendsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DividendsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DividendsModel> validator() {
		return new DividendsModelValidator();
	}

	@Override
	public Validator<? super DividendsModel> typeFormatValidator() {
		return new DividendsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendsModel, Set<String>> onlyExistsValidator() {
		return new DividendsModelOnlyExistsValidator();
	}
}
