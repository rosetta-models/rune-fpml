package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NetAndOrGrossModel;
import fpml.confirmation.validation.NetAndOrGrossModelTypeFormatValidator;
import fpml.confirmation.validation.NetAndOrGrossModelValidator;
import fpml.confirmation.validation.exists.NetAndOrGrossModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NetAndOrGrossModel.class)
public class NetAndOrGrossModelMeta implements RosettaMetaData<NetAndOrGrossModel> {

	@Override
	public List<Validator<? super NetAndOrGrossModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.NetAndOrGrossModel>create(fpml.confirmation.validation.datarule.NetAndOrGrossModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NetAndOrGrossModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NetAndOrGrossModel> validator() {
		return new NetAndOrGrossModelValidator();
	}

	@Override
	public Validator<? super NetAndOrGrossModel> typeFormatValidator() {
		return new NetAndOrGrossModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NetAndOrGrossModel, Set<String>> onlyExistsValidator() {
		return new NetAndOrGrossModelOnlyExistsValidator();
	}
}
